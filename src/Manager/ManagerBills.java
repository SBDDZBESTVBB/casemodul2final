package Manager;

import Taodoituong.Bills;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerBills {
    public ArrayList<Bills> bills = new ArrayList<>();

    public ArrayList<Bills> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bills> bills) {
        this.bills = bills;
    }
    public void addBills(Bills bill){
        if (bills.size()==0){
            bill.setId(1);
            bills.add(bill);
        }
        else
        if(bills.size()>0){
            bill.setId(bills.get(bills.size()-1).getId()+1);
            bills.add(bill);
        }

    }

    public Bills findBillbyid(int idbill) {
        for (Bills bills: bills
        ) {
            if (idbill==bills.getId()) return bills;
        }
        return null;
    }

    public void findBillinmoth() {
        LocalDate datenow = LocalDate.now();
        for (Bills bill: bills
        ) {
            if(bill.getDate().getMonth()==datenow.getMonth()&&bill.getDate().getYear()==datenow.getYear()){
                bill.Show();
            }
        }
    }

    public double sumBillinmonth() {
        LocalDate datenow = LocalDate.now();
        double sum = 0;
        for (Bills bill: bills
        ) {
            if(bill.getDate().getMonth()==datenow.getMonth()&&bill.getDate().getYear()==datenow.getYear()){
                sum = sum + bill.getSumofbills();
            }
        }
        return sum;
    }
    public void Show(){
        for (Bills b: bills
        ) {
            b.Show();
        }
    }
}
