package class1;

public class TrainPrint {

        {
            System.out.printf("Empty block initial %s\n", this.getClass());
        }
        static {
            System.out.printf("Static initial %s\n", TrainPrint.class);
        }
        public TrainPrint() {
            System.out.printf("Initial %s\n", this.getClass());
        }
        public void Print()  {
            System.out.println("java");
        }
}
