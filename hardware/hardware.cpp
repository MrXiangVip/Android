//
// Created by xshx on 2022/9/20.
//
#include "hardware.h"
#include <dlfcn.h>
#include <string.h>
#include <pthread.h>
#include <errno.h>
#include <limits.h>
#include <stdio.h>
#include <unistd.h>

#define HAL_LIBRARY_PATH1 "/system/lib/hw"
#define HAL_LIBRARY_PATH2 "/vendor/lib/hw"
#define HAL_LIBRARY_PATH3 "/odm/lib/hw"
#define HAL_LIBRARY_PATH4 "./hardware"



/**
 * Load the file defined by the variant and if successful
 * return the dlopen handle and the hmi.
 * @return 0 = success, !0 = failure.
 */
static int load(const char *id,
                const char *path,
                const struct hw_module_t **pHmi)
{
    printf("%s id %s, path %s\n", __func__,  id, path);
    int status = -EINVAL;
    void *handle = NULL;
    struct hw_module_t *hmi = NULL;
    const bool try_system = true;

    /*
     * load the symbols resolving undefined symbols before
     * dlopen returns. Since RTLD_GLOBAL is not or'd in with
     * RTLD_NOW the external symbols will not be global
     */

    handle = dlopen(path, RTLD_NOW);
//    else {
//        handle = android_load_sphal_library(path, RTLD_NOW);
//    }
    if (handle == NULL) {
        char const *err_str = dlerror();
        printf("load: module=%s\n%s", path, err_str?err_str:"unknown");
        status = -EINVAL;
//        goto done;
    }

    /* Get the address of the struct hal_module_info. */
    const char *sym = HAL_MODULE_INFO_SYM_AS_STR;
    printf("dlsym %s \n", sym);
    hmi = (struct hw_module_t *)dlsym(handle, sym);// 从一个动态链接库或者可执行文件中获取到符号地址
    if (hmi == NULL) {
        printf("load: couldn't find symbol %s", sym);
        status = -EINVAL;
        goto done;
    }

    /* Check that the id matches */
    if (strcmp(id, hmi->id) != 0) {
        printf("load: id=%s != hmi->id=%s", id, hmi->id);
        status = -EINVAL;
        goto done;
    }

    hmi->dso = handle;

    /* success */
    status = 0;

    done:
    if (status != 0) {
        hmi = NULL;
        if (handle != NULL) {
            dlclose(handle);
            handle = NULL;
        }
    } else {
        printf("loaded HAL id=%s path=%s hmi=%p handle=%p",
              id, path, *pHmi, handle);
    }

    *pHmi = hmi;

    return status;
}

/*
 * Check if a HAL with given name and subname exists, if so return 0, otherwise
 * otherwise return negative.  On success path will contain the path to the HAL.
 */
static int hw_module_exists(char *path, size_t path_len, const char *name,
                            const char *subname)
{
    printf("%s path %s, name %s, subname %s\n", __func__, path, name, subname);
    snprintf(path, path_len, "%s/%s%s.so",
             HAL_LIBRARY_PATH4, subname,name );
    printf("access path %s\n", path);

    if (access(path, R_OK) == 0)
        return 0;
    snprintf(path, path_len, "%s/%s%s.so",
             HAL_LIBRARY_PATH3,subname, name );
    printf("access path %s\n", path);
    if (access(path, R_OK) == 0)
        return 0;

    snprintf(path, path_len, "%s/%s%s.so",
             HAL_LIBRARY_PATH2, subname, name );
    printf("access path %s\n", path);
    if (access(path, R_OK) == 0)
        return 0;

    snprintf(path, path_len, "%s/%s%s.so",
             HAL_LIBRARY_PATH1, subname, name );
    printf("access path %s\n", path);
    if (access(path, R_OK) == 0)
        return 0;

    return -ENOENT;
}

int hw_get_module_by_class(const char *class_id, const char *inst,
                           const struct hw_module_t **module)
{
    printf("%s %s\n",__func__, class_id);

    int i = 0;
    char path[PATH_MAX] = {0};
    char name[PATH_MAX] = {0};


    strncpy(name, class_id, PATH_MAX);

    /*
     * Here we rely on the fact that calling dlopen multiple times on
     * the same .so will simply increment a refcount (and not load
     * a new copy of the library).
     * We also assume that dlopen() is thread-safe.
     */

    /* Loop through the configuration variants looking for a module */


    /* Nothing found, try the default */
    if (hw_module_exists(path, sizeof(path), name, "lib") == 0) {
        goto found;
    }

    return -ENOENT;

    found:
    /* load the module, if this fails, we're doomed, and we should not try
     * to load a different variant. */
    return load(class_id, path, module);
}

int hw_get_module(const char *id, const struct hw_module_t **module)
{
    printf("%s %s\n",__func__, id);
    return hw_get_module_by_class(id, NULL, module);
}

//https://blog.csdn.net/feelinghappy/article/details/107530294