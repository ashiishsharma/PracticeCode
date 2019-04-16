package tech.blueglacier;

import java.util.HashMap;
import java.util.Map;

public class GateManager {
    private Map<String, EntryGate> entryGateMap;
    private Map<String, ExitGate> exitGateMap;

    public GateManager() {
        entryGateMap = new HashMap<>();
        exitGateMap = new HashMap<>();
    }

    public void addEntryGate(EntryGate entryGate) {
        entryGateMap.put(entryGate.getGateName(), entryGate);
    }

    public void addExitGate(ExitGate exitGate) {
        exitGateMap.put(exitGate.getGateName(), exitGate);
    }

    public Map<String, EntryGate> getEntryGateMap() {
        return entryGateMap;
    }

    public void setEntryGateMap(Map<String, EntryGate> entryGateMap) {
        this.entryGateMap = entryGateMap;
    }

    public Map<String, ExitGate> getExitGateMap() {
        return exitGateMap;
    }

    public void setExitGateMap(Map<String, ExitGate> exitGateMap) {
        this.exitGateMap = exitGateMap;
    }
}
