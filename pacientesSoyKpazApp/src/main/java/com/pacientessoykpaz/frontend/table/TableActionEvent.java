package com.pacientessoykpaz.frontend.table;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onPay(int row);

    public void onOtherAction(int row);

    public void onDelete(int row);
}
