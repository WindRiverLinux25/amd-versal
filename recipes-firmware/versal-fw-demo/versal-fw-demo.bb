SUMMARY = "Full Bitstream loading app firmware using dfx_user_dts bbclass"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit dfx_user_dts

FW_DEMO_FILES ?= ""
SRC_URI = " ${@" ".join(["file://%s" % f for f in (d.getVar('FW_DEMO_FILES') or "").split()])}"

COMPATIBLE_MACHINE:amd-versal = "amd-versal"
