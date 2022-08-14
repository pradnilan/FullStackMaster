package com.example.resttemp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@NoArgsConstructor@AllArgsConstructor
public class FCU {

    private int id;
    private boolean cmd;
    private boolean status;
    private float rmt;
    private float rmt_sp;
    private boolean trip;

    public boolean isCmd() {
        return cmd;
    }

    public void setCmd(boolean cmd) {
        this.cmd = cmd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
