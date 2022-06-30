package section13;

import java.util.ArrayList;
import java.util.Objects;

public class HashTableProbing {
    ArrayList<PhoneEntry> table;
    int size;

    public HashTableProbing(int size) {
        this.size = size;
        this.table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    public boolean put(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        for (int i = index; i < size; i++) {
            if (table.get(i) == null || table.get(i).deleted) {
                table.set(i, phoneEntry);
                return true;
            } else if(table.get(i) != null && Objects.equals(table.get(i).name, phoneEntry.name)) {
                table.get(i).phone = phoneEntry.phone;
            }
        }
        return false;
    }

    public boolean get(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        for (int i = index; i < size; i++) {
            if(Objects.equals(table.get(i), phoneEntry)){
                return table.get(i).deleted;
            }
        }
        return false;
    }

    public boolean remove(PhoneEntry phoneEntry) {
        int index = phoneEntry.hashCode() % size;
        for (int i = index; i < size; i++) {
            if(Objects.equals(table.get(i), phoneEntry)){
                 table.get(i).deleted= true;
                 return true;
            }
        }
        return false;
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
        boolean deleted;

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
