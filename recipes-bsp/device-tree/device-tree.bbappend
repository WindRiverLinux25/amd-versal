FILESEXTRAPATHS:prepend:amd-versal := "${THISDIR}/files:"

EXTRA_DT_INCLUDE_FILES:append:amd-versal = " \
	versal-i2c-dev.dtsi \
	versal-wdt.dtsi \
"

COMPATIBLE_MACHINE:amd-versal = "amd-versal"
