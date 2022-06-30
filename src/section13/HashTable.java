package section13;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable {
    ArrayList<ArrayList<PhoneEntry>> table;
    int size;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<>());
        }
    }

    public void put(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        for (PhoneEntry p : table.get(index)) {
            if (Objects.equals(p.name, phoneEntry.name)) {
                p.phone = phoneEntry.phone;
                return;
            }
        }
        table.get(index).add(phoneEntry);
    }

    public boolean get(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        for (PhoneEntry p : table.get(index)) {
            if (Objects.equals(p, phoneEntry)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        return table.get(index).remove(phoneEntry);
    }

    public void printAll() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return table.toString();
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

        @Override
        public int hashCode() {
            return Objects.hash(name);
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
