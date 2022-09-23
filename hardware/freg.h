//
// Created by xshx on 2022/9/20.
//

#ifndef HARDWARE_FREG_H
#define HARDWARE_FREG_H

#define FREG_HARDWARE_MODULE_ID "freg"

#define FREG_MODULE_API_VERSION_0_2  HARDWARE_MODULE_API_VERSION(0, 2)

struct freg_module_t {
    struct hw_module_t common;
};

struct freg_device_t {
    struct hw_device_t common;
    int value;
    int (*set_val )(struct freg_device_t *dev, int val);
    int (*get_val )(struct freg_device_t *dev, int *val);
};

int freg_device_open(const struct hw_module_t* module, const char* id,struct hw_device_t** device);
int freg_get_val(struct freg_device_t *dev, int *val);
int freg_set_val(struct freg_device_t *dev, int val);
int freg_device_close(struct hw_device_t *device);

#endif //HARDWARE_FREG_H
