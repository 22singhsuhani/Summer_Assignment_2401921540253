class SnapshotArray {

    List<int[]>[] arr;
    int snapId;

    public SnapshotArray(int length) {
        arr = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new ArrayList<>();
            arr[i].add(new int[]{0, 0}); // Initial value
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        List<int[]> list = arr[index];

        if (list.get(list.size() - 1)[0] == snapId) {
            list.get(list.size() - 1)[1] = val;
        } else {
            list.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> list = arr[index];

        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid)[0] <= snap_id) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return list.get(r)[1];
    }
}