# enviroment variable pointing to current directory
LOCAL_PATH := $(call my-dir) 

# clear all previously declarated enviroment variables
include $(CLEAR_VARS)

# list files to build
LOCAL_SRC_FILES := com_alex_jniexample_MathNativeLib.c

# name od the created library
LOCAL_MODULE := com_alex_jniexample_MathNativeLib

# kind of build we are performing here
include $(BUILD_SHARED_LIBRARY)