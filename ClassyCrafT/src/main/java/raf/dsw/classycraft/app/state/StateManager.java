package raf.dsw.classycraft.app.state;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.state.concrete.*;
@Getter
@Setter
public class StateManager {

    private State currentState;
    private AddClassState addClassState;
    private EditState editState;
    private MoveState moveState;
    private SelectState selectState;
    private ZoomState zoomState;

    public StateManager(){
        initState();
    }
    private void initState(){
        addClassState = new AddClassState();
        editState = new EditState();
        moveState = new MoveState();
        selectState = new SelectState();
        zoomState = new ZoomState();
        currentState = null;
    }

    public State getCurrentState(){ return currentState; }

    public void setAddClassState(){ currentState = addClassState; }
    public void setEditState(){ currentState = editState; }
    public void setMoveState(){ currentState = moveState; }
    public void setSelectState(){ currentState = selectState; }
    public void setZoomState(){ currentState = zoomState; }
}
