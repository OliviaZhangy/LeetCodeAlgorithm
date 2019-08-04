package src.Olivia;

public class factual1 {
        /**
         * @param readings readings[i][0] = time, readings[i][1] = speed
         * @param endTime  end time of calculation
         * @return total distance before end
         */
        public double speed(double[][] readings, double endTime) {

            /* Corner case */
            if (readings.length == 1) {
                return (endTime / (double) 3600) * readings[0][1];
            }

            double total = 0;       // total distance

            for (int i = 1; i < readings.length; i++) {

                if (readings[i][0] < endTime) {
                    total += (((readings[i][0] - readings[i - 1][0]) / (double) 3600) * readings[i - 1][1]);
                } else {
                    total += (((endTime - readings[i - 1][0]) / (double) 3600) * readings[i - 1][1]);
                    break;
                }
            }
            if (endTime > readings[readings.length - 1][0]) {
                total += ((endTime - readings[readings.length - 1][0]) / (double) 3600 * readings[readings.length - 1][1]);
            }

            return total;
        }

        public static void main(String[] args) {
            System.out.println(new factual1().speed(new double[][]{{0, 90}, {300, 80}}, (double) 400));
        }
    }


