//
// Created by xshx on 2022/9/21.
//

#include "hardware.h"
#include "freg.h"
#include <stddef.h>
#include "stdio.h"
#include <stdlib.h>
#include <string.h>



static struct hw_module_methods_t freg_module_methods = {
        .open = freg_device_open,
};

struct freg_module_t HAL_MODULE_INFO_SYM = {
        .common = {
                .tag = HARDWARE_MODULE_TAG,
                .module_api_version = FREG_MODULE_API_VERSION_0_2,
                .hal_api_version = HARDWARE_HAL_API_VERSION,
                .id = FREG_HARDWARE_MODULE_ID,
                .name = "Default Power HAL",
                .author = "The Android Open Source Project",
                .methods = &freg_module_methods,
        },

};

int freg_device_open(const struct hw_module_t* module,const char* id, struct hw_device_t** device){
    printf("%s\n", __func__);
    printf("open freg success \n");
    struct freg_device_t *dev = (struct freg_device_t *)malloc(sizeof(struct freg_device_t));
    memset( dev, 0 , sizeof(struct freg_device_t));
    printf("dev ->%x\n", dev);
    dev->set_val = freg_set_val;
    dev->get_val = freg_get_val;
    dev->value=0;
    *device = (hw_device_t *)(dev);
    printf("dev ->%x  %d\n", dev, dev->value);

    return 0;
}

int freg_device_close(struct hw_device_t *device){
    printf("%s \n", __func__);
    return  0;
}

int freg_get_val(struct freg_device_t *dev, int *val){
    printf("%s \n", __func__);
    *val = dev->value;
    return 0;
}

int freg_set_val(struct freg_device_t *dev, int val){
    printf("%s %d\n", __func__, val);
    dev->value = val;
    return 0;
}

