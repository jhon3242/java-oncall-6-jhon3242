package oncall;

public class Distributor {
    private Workers weekdayWorkers;
    private Workers weekendWorkers;
    private String tempWorker = null;

    public Distributor(Workers weekdayWorkers, Workers weekendWorkers) {
        this.weekdayWorkers = weekdayWorkers;
        this.weekendWorkers = weekendWorkers;
    }

//    public String getNextWorker(String beforeWorker, Date date) {
//        if (tempWorker != null) {
//            String worker = tempWorker;
//            tempWorker = null;
//            return worker;
//        }
//        String worker = getWorker(date);
//        if (worker.equals(beforeWorker)) {
//            tempWorker = worker;
//            return getWorker(date); // 두번 겹치는 경우도 다뤄야할까?
//        }
//        return worker;
//    }

    public String getWorker(Date date) {
        if (date.isDayOff()) {
//            date.nextDay(); // TODO : 넣을지 말지 고민
            return weekendWorkers.getWorker();
        }
//        date.nextDay(); // TODO : 넣을지 말지 고민
        return weekdayWorkers.getWorker();
    }
}
