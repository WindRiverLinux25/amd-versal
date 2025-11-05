#
# Copyright (C) 2025 Wind River Systems, Inc.
#

COMPATIBLE_MACHINE:amd-versal = "amd-versal"

TARGET_SUPPORTED_KTYPES:amd-versal = "standard preempt-rt"

KERNEL_DTC_FLAGS:append:amd-versal = " -@"

FILESEXTRAPATHS:prepend:amd-versal := "${THISDIR}/files:"
SRC_URI:append:amd-versal = " \
	file://0001-iio-versal-sysmon-Initialize-the-non-static-sysfs-at.patch \
"
