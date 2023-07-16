package com.sh_tab.sh_j_engine.systems.shinput;

public class Action {
    public Actions action;
    protected Actioner actioner;
    public Action(Actioner actioner, Actions action, Class<? extends WhatToDo> act) {
        this.actioner = actioner;
        this.action = action;
    }
    public abstract class WhatToDo {

        public void makeAction() {

        }

    }
}
