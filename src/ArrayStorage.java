import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int resumeInStorage;

    void clear() {
        Arrays.fill(storage, 0, resumeInStorage, null);
        resumeInStorage = 0;
    }

    void save(Resume r) {
        storage[resumeInStorage] = r;
        resumeInStorage++;
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        if(index != -1) {
            return storage[index];
        }
        return null;
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if(index != -1) {
            resumeInStorage--;
            System.arraycopy(storage, index + 1, storage, index, resumeInStorage - index);
            storage[resumeInStorage] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, resumeInStorage);
    }

    int size() {
        return storage.length;
    }

    private int findIndex(String uuid) {
        for(int i = 0; i < resumeInStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
