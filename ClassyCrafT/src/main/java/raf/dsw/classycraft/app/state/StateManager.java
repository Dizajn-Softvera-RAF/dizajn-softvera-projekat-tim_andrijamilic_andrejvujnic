package raf.dsw.classycraft.app.state;

import raf.dsw.classycraft.app.state.concrete.*;

public class StateManager {

    private State currentState;
    private AddAgregacijaState addAgregacijaState;
    private AddKompozicijaState addKompozicijaState;
    private AddGeneralizacijeState addGeneralizacijeState;
    private AddZavisnostState addZavisnostState;
    private DeleteState deleteState;
    private AddInterfaceState addInterfaceState;
    private AddEnumState addEnumState;
    private AddClassState addClassState;
    private EditState editState;
    private MoveState moveState;
    private SelectState selectState;
    private ZoomState zoomState;

    private DuplicateState duplicateState;

    public StateManager(){
        initState();
    }
    private void initState(){
        addClassState = new AddClassState();
        addInterfaceState = new AddInterfaceState();
        addEnumState = new AddEnumState();
        deleteState = new DeleteState();
        addAgregacijaState = new AddAgregacijaState();
        addGeneralizacijeState = new AddGeneralizacijeState();
        addKompozicijaState = new AddKompozicijaState();
        addZavisnostState = new AddZavisnostState();
        editState = new EditState();
        moveState = new MoveState();
        selectState = new SelectState();
        zoomState = new ZoomState();
        duplicateState = new DuplicateState();
        currentState = addClassState;
    }

    public State getCurrentState(){ return currentState; }

    public void setAddClassState(){currentState = addClassState;
    }

    public void setDuplicateState()
    {
        currentState = duplicateState;
    }
    public void setAddInterfaceState()
    {
        currentState = addInterfaceState;
    }
    public void setAddEnumState()
    {
        currentState = addEnumState;
    }

    public void setDeleteState() {
        currentState = deleteState;
    }

    public void setAddAgregacijaState(){
        currentState = addAgregacijaState;
    }
    public void setAddGeneralizacijeState(){
        currentState = addGeneralizacijeState;
    }
    public void setAddKompozicijaState(){
        currentState = addKompozicijaState;
    }
    public void setAddZavisnostState(){
        currentState = addZavisnostState;
    }
    public void setEditState(){ currentState = editState; }
    public void setMoveState(){ currentState = moveState; }
    public void setSelectState(){ currentState = selectState; }
    public void setZoomState(){ currentState = zoomState; }
}
