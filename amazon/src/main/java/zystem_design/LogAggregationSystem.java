package zystem_design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// public class LogAggregator {
public class LogAggregationSystem {

  Map<Integer, List<Integer>> machineLogIdMap = new HashMap<>();
  Map<Integer, List<Integer>> serviceLogIdMap = new HashMap<>();
  Map<Integer, List<String>> serviceLogMsgMap = new HashMap<>();
  // public LogAggregator(int machines, int services) {
  public LogAggregationSystem(int machines, int services) {

  }

  public void pushLog(int logId, int machineId, int serviceId, String message) {
    if(!machineLogIdMap.containsKey(machineId)) {
      machineLogIdMap.put(machineId, new LinkedList<>());
    }
    machineLogIdMap.get(machineId).add(logId);

    if(!serviceLogIdMap.containsKey(serviceId)) {
      serviceLogIdMap.put(serviceId, new LinkedList<>());
    }
    serviceLogIdMap.get(serviceId).add(logId);

    if(!serviceLogMsgMap.containsKey(serviceId)) {
      serviceLogMsgMap.put(serviceId, new LinkedList<>());
    }
    serviceLogMsgMap.get(serviceId).add(message);
  }

  public List<Integer> getLogsFromMachine(int machineId) {
    List<Integer> result = new LinkedList<>();
    if(machineLogIdMap.containsKey(machineId)) {
      for(Integer logId : machineLogIdMap.get(machineId)) {
        result.add(logId);
      }
    }
    return result;
  }

  public List<Integer> getLogsOfService(int serviceId) {
    List<Integer> result = new LinkedList<>();
    if(serviceLogIdMap.containsKey(serviceId)) {
      for(Integer logId : serviceLogIdMap.get(serviceId)) {
        result.add(logId);
      }
    }
    return result;
  }

  public List<String> search(int serviceId, String searchString) {
    List<String> result = new LinkedList<>();
    if(serviceLogMsgMap.containsKey(serviceId)) {
      for(String msg : serviceLogMsgMap.get(serviceId)) {
        if(msg.contains(searchString)) {
          result.add(msg);
        }
      }
    }
    return result;
  }
}
