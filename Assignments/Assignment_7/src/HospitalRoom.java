import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

public class HospitalRoom {
 // in the room use Set to accomplish leave and in randomly
 // waiting should be queue to accomplish first come first serve
 private Set<Doctor> doctorsIn;
    private Set<Patient> patientsIn;
    private Queue<Doctor> doctorsWaiting;
    private Queue<Patient> patientsWaiting;
    private static final int MAX_PATIENTS = 3;
    private static final int MAX_DOCTOR = 1;
    
    public HospitalRoom() {
     doctorsIn = new HashSet<Doctor>();
     patientsIn = new HashSet<Patient>();
     doctorsWaiting = new LinkedList<Doctor>();
     patientsWaiting = new LinkedList<Patient>();
    }

    public synchronized boolean doctorEnter(Doctor d) throws InterruptedException {
     // can allow doctor to enter
        if (doctorsIn.size() < MAX_DOCTOR) {
         doctorsWaiting.add(d);
         Doctor nextIn = doctorsWaiting.remove();
         doctorsIn.add(nextIn);
         System.out.println("Doctor " + nextIn.name + " Entered, number of doctor " + doctorsIn.size());
         return true;
        } 
        if (!this.doctorsWaiting.contains(d)) { // make sure doctorsIn size is always < max_doctor
         doctorsWaiting.add(d);
         System.out.println("Doctor " + d.name + " is waiting to Enter, number of doctor " + doctorsIn.size());
        }
        return false;
    }

    public synchronized boolean doctorLeave(Doctor d) throws InterruptedException {
       if (doctorsIn.size() == 0 || doctorsIn == null) return false;
       if (doctorsIn.contains(d)) {
        doctorsIn.remove(d);
        System.out.println("Doctor " + d.name + " Left, number of doctor " + doctorsIn.size());
        return true;
       }
       return false;
    }

    public synchronized boolean patientEnter(Patient p) throws InterruptedException {
     // ok to go in
        if (patientsIn.size() < MAX_PATIENTS) {
         patientsWaiting.add(p);
         Patient nextIn = patientsWaiting.remove();
         patientsIn.add(nextIn);
         System.out.println("Patient " + nextIn.name + " entered, number of patients " + patientsIn.size());
         return true;
        } 
        if (!patientsWaiting.contains(p)) {
         patientsWaiting.add(p);
         System.out.println("Patient " + p.name + " is waiting to Enter, number of patients " + patientsIn.size());
        }
        return false;
    }

    public synchronized boolean patientLeave(Patient p) throws InterruptedException {
     if (patientsIn.size() == 0 || patientsIn == null) return false;
        if (patientsIn.contains(p)) {
         patientsIn.remove(p);
         System.out.println("Patient " + p.name + " left");
         return true;
        }
        return false;
    }

}

class Doctor {
    public String name;
    public Doctor(String name) {
        this.name = name;
    }
}

class Patient {
    public String name;
    public Patient(String name) {
        this.name = name;
    }
}

class Main2 {
    public static void main(String[] args) {
        HospitalRoom room = new HospitalRoom();
        Doctor siva = new Doctor("siva");
        Doctor john = new Doctor("john");
        Patient p1 = new Patient("p1");
        Patient p2 = new Patient("p2");
        Patient p3= new Patient("p3");
        Patient p4 = new Patient("p4");
        Patient p5 = new Patient("p5");
        Thread doctor1 = new Thread(() -> {
            try {
                while(!room.doctorEnter(siva)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(siva)) {}

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread doctor2 = new Thread(() -> {
            try {
                while(!room.doctorEnter(john)) {}
                Thread.sleep(500);
                while(!room.doctorLeave(john)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient1 = new Thread(() -> {
            try {
                while(!room.patientEnter(p1)) {}
                Thread.sleep(500);
                while(!room.patientLeave(p1)) {}
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient2 = new Thread(() -> {
            try {
                while(!room.patientEnter(p2)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p2)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient3 = new Thread(() -> {
            try {
                while(!room.patientEnter(p3)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p3)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient4 = new Thread(() -> {
            try {
                while(!room.patientEnter(p4)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p4)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread patient5 = new Thread(() -> {
            try {
                while(!room.patientEnter(p5)) {};
                Thread.sleep(500);
                while(!room.patientLeave(p5)) {};
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        doctor1.start();
        doctor2.start();
        patient1.start();
        patient2.start();
        patient3.start();
        patient4.start();
        patient5.start();
    }
}