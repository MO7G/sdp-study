package adapter.myExample;

// AdapterExample.java
 class AdapterExample {

    // Target Interface: Type-C charger
    interface TypeC {
        void charge();
    }

    // Existing Class: Micro-USB charger
    static class MicroUSBCharger {
        public void microUSBCharge() {
            System.out.println("Charging with Micro-USB charger");
        }
    }

    // Adapter Class: Converts Micro-USB to Type-C
    static class MicroUSBToTypeCAdapter implements TypeC {
        private MicroUSBCharger microUSBCharger;

        public MicroUSBToTypeCAdapter(MicroUSBCharger microUSBCharger) {
            this.microUSBCharger = microUSBCharger;
        }

        @Override
        public void charge() {
            microUSBCharger.microUSBCharge(); // Delegate charging to Micro-USB
        }
    }

    // Main method to demonstrate the adapter pattern
    public static void main(String[] args) {
        // Create an old Micro-USB charger
        MicroUSBCharger oldCharger = new MicroUSBCharger();

        // Use an adapter to make it compatible with Type-C
        TypeC adapter = new MicroUSBToTypeCAdapter(oldCharger);

        // Charge the phone using the adapter
        adapter.charge(); // Outputs: Charging with Micro-USB charger
    }
}
