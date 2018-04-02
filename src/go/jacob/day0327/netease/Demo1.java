package go.jacob.day0327.netease;

public class Demo1 {


    private static class Work implements Comparable<Work> {
        private int d;
        private int p;

        public Work(int d, int p) {
            this.d = d;
            this.p = p;
        }


        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }

        public int compareTo(Work o) {
            return this.d-o.d;
        }
    }
}
