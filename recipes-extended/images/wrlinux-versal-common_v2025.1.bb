SUMMARY = "A recipe to pack up necessary files into tar.gz for Vitis to use"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INSANE_SKIP:${PN} = "installed-vs-shipped"

inherit deploy

do_fetch[depends] += "wrlinux-image-std:do_image_complete"
do_fetch[depends] += "wrlinux-image-std:do_populate_sdk"

COMMON_DIR = "wrlinux-versal-common-${PV}"

do_compile() {
	install -d ${B}/${COMMON_DIR}
	cp ${DEPLOY_DIR_IMAGE}/wrlinux-image-*.rootfs.ext4 ${B}/${COMMON_DIR}/rootfs.ext4
	cp ${DEPLOY_DIR_IMAGE}/wrlinux-image-*.rootfs.manifest ${B}/${COMMON_DIR}/rootfs.manifest
	cp ${DEPLOY_DIR_IMAGE}/wrlinux-image-*.rootfs.tar.gz ${B}/${COMMON_DIR}/rootfs.tar.gz
	cp ${DEPLOY_DIR_IMAGE}/arm-trusted-firmware.elf ${B}/${COMMON_DIR}/bl31.elf
	cp ${DEPLOY_DIR_IMAGE}/u-boot.elf ${B}/${COMMON_DIR}/u-boot.elf
	cp ${DEPLOY_DIR_IMAGE}/boot.scr ${B}/${COMMON_DIR}/boot.scr
	cp ${DEPLOY_DIR_IMAGE}/Image ${B}/${COMMON_DIR}/Image
	cp ${DEPLOY_DIR}/sdk/*.sh ${B}/${COMMON_DIR}/sdk.sh
}

do_install() {
	cd ${B}
	tar zcvf ${D}/${COMMON_DIR}.tar.gz ${COMMON_DIR}
}

do_deploy() {
	install -m 0644  ${D}/${COMMON_DIR}.tar.gz ${DEPLOYDIR}
}
addtask deploy after install

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "amd-versal"
