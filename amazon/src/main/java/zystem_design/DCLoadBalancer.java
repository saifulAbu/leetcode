package zystem_design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Application {
  int id;
  int loadUse;

  Application (int id, int loadUse) {
    this.id = id;
    this.loadUse = loadUse;
  }

  @Override
  public int hashCode() {
    return this.id;
  }
}

class Machine implements Comparable<Machine>{
  int id;
  int remainingCapacity;
  List<Application> appList;

  Machine(int id, int capacity) {
    this.id = id;
    this.remainingCapacity = capacity;
    appList = new LinkedList<>();
  }

  public int addApp(Application app) {
    if(remainingCapacity < app.loadUse) {
      return -1;
    }
    remainingCapacity -= app.loadUse;
    appList.add(app);
    return 0;
  }

  public void removeApp(Application app) {
    if(appList.remove(app)) {
      remainingCapacity += app.loadUse;
    }
  }

  public List<Integer> getAppList() {
    List<Integer> resultAppList = new LinkedList<>();
    for(Application app : appList) {
      resultAppList.add(app.id);
    }
    return resultAppList;
  }

  @Override
  public int compareTo(Machine that) {
    if(this.remainingCapacity == that.remainingCapacity) {
      return this.id - that.id;
    }
    return that.remainingCapacity - this.remainingCapacity;
  }

  @Override
  public int hashCode() {
    return this.id;
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o)
//      return true;
//    if (o == null || getClass() != o.getClass())
//      return false;
//    Machine that = (Machine) o;
//    return this.id == that.id;
//  }
}

public class DCLoadBalancer {
  PriorityQueue<Machine> machineQ = new PriorityQueue<>();
  HashMap<Integer, Machine> machineIdMap = new HashMap<>();
  HashMap<Integer, Application> appIdMap = new HashMap<>();
  HashMap<Application, Machine> appMachineMap = new HashMap<>();

  public DCLoadBalancer() {

  }

  public void addMachine(int machineId, int capacity) {
    Machine machine = new Machine(machineId, capacity);
    machineIdMap.putIfAbsent(machineId, machine);
    machineQ.add(machine);
  }

  public void removeMachine(int machineId) {
    Machine machine = machineIdMap.get(machineId);
    List<Integer> appList = machine.getAppList();
    List<Application> applicationObjList = new LinkedList<>();

    machineQ.remove(machine);

    for(Integer appId : appList) {
      Application app = appIdMap.get(appId);
      applicationObjList.add(app);
      machine.removeApp(app);
      appMachineMap.remove(app);
      appIdMap.remove(app);
    }

    machineIdMap.remove(machine);
    for(Application app : applicationObjList) {
      addApplication(app);
    }
  }

  public void removeMachine2(int machineId) {
    Machine machine = machineIdMap.get(machineId);
    List<Integer> appList = machine.getAppList();
    List<Application> applicationObjList = new LinkedList<>();
    for(Integer appId : appList) {
      applicationObjList.add(appIdMap.get(appId));
      stopApplication(appId);
    }
    machineQ.remove(machine);
    machineIdMap.remove(machine);
    for(Application app : applicationObjList) {
      addApplication(app);
    }
  }

  private int addApplication(Application app) {
    if(machineQ.isEmpty() || machineQ.peek().remainingCapacity < app.loadUse) {
      return -1;
    }
    appIdMap.putIfAbsent(app.id, app);
    Machine machine = machineQ.poll();
    machine.addApp(app);
    appMachineMap.put(app, machine);
    machineQ.offer(machine);
    return machine.id;
  }

  public int addApplication(int appId, int loadUse) {
    if(machineQ.isEmpty() || machineQ.peek().remainingCapacity < loadUse) {
      return -1;
    }

    return addApplication(new Application(appId, loadUse));
  }

  public void stopApplication(int appId) {
    Application app = appIdMap.get(appId);
    Machine machine = appMachineMap.get(app);
    machineQ.remove(machine);
    machine.removeApp(app);
    machineQ.offer(machine);
    appMachineMap.remove(app);
    appIdMap.remove(app);
  }

  public List<Integer> getApplications(int machineId) {
    return machineIdMap.get(machineId).getAppList();
  }
}
