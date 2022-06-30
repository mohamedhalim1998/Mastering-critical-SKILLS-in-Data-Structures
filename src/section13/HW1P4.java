package section13;

import java.util.ArrayList;
import java.util.Objects;

public class HW1P4 {

    public static int hashString(String str, int n) {
        long sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            int s = 0;
            if (Character.isUpperCase(c)) {
                s = 26 + c - 'A';
            } else if (Character.isLowerCase(c)) {
                s = c - 'a';
            } else {
                s = 2 * 26 + c - '0';
            }
            sum = (sum + s * (2 * 26 + 10)) % n;
        }

        return (int) (sum % n);
    }


    public static class HashTable {
        ArrayList<ArrayList<PhoneEntry>> table;
        int capacity;
        double loadFactor;
        double limitLoadFactor;
        int size;

        public HashTable(int capacity, double limitLoadFactor) {
            this.capacity = capacity;
            this.table = new ArrayList<>();
            this.limitLoadFactor = limitLoadFactor;
            for (int i = 0; i < capacity; i++) {
                table.add(new ArrayList<>());
            }
        }

        public void put(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode(capacity);
            for (PhoneEntry p : table.get(index)) {
                if (Objects.equals(p.name, phoneEntry.name)) {
                    p.phone = phoneEntry.phone;
                    return;
                }
            }
            table.get(index).add(phoneEntry);
            size++;
            updateLoadFactor();
        }

        private void updateLoadFactor() {
            loadFactor = size * 1.0 / capacity;
            if (loadFactor > limitLoadFactor) {
                rehash();
                loadFactor = size * 1.0 / capacity;
            }
        }

        private void rehash() {
            capacity = 2 * capacity;
            ArrayList<ArrayList<PhoneEntry>> old = table;
            table = new ArrayList<>();
            for (int i = 0; i < capacity; i++) {
                table.add(new ArrayList<>());
            }
            for (ArrayList<PhoneEntry> phoneEntries : old) {
                for (PhoneEntry phoneEntry : phoneEntries) {
                    put(phoneEntry);
                }
            }
        }

        public boolean get(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode() % capacity;
            for (PhoneEntry p : table.get(index)) {
                if (Objects.equals(p, phoneEntry)) {
                    return true;
                }
            }
            return false;
        }

        public boolean remove(PhoneEntry phoneEntry) {
            int index = phoneEntry.hashCode() % capacity;
            return table.get(index).remove(phoneEntry);
        }

        public void printAll() {
            System.out.println(this);
        }

        @Override
        public String toString() {
            return table.toString();
        }


    }

    public static class PhoneEntry {
        String name;
        String phone;

        public PhoneEntry(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneEntry that = (PhoneEntry) o;
            return Objects.equals(name, that.name) && Objects.equals(phone, that.phone);
        }


        public int hashCode(int capacity) {
            return hashString(name, capacity);
        }

        @Override
        public String toString() {
            return "PhoneEntry{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }


}
