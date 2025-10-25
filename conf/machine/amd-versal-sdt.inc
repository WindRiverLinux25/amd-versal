WORKFLOW_MACHINE_NAME ??= ""

MACHINE_CONF = "${@'${WORKFLOW_MACHINE_NAME}.conf' if d.getVar("WORKFLOW_MACHINE_NAME") != "" else 'versal-generic.conf'}"

require conf/machine/${MACHINE_CONF}
