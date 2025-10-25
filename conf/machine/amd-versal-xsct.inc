WORKFLOW_MACHINE_NAME ??= ""

MACHINE_CONF = "${@'${WORKFLOW_MACHINE_NAME}.conf' if d.getVar("WORKFLOW_MACHINE_NAME") != "" else '${VERSAL_TARGET_BOARD}-versal.conf'}"

require conf/machine/${MACHINE_CONF}
