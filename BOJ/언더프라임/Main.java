class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        isPrime = new boolean[B + 1];
        getPrime(B);

        int answer = 0;
        for (int i = A; i <= B; i++) {
            int primeLength = getPrimeLength(i);
            if (!isPrime[primeLength] && primeLength != 1) {
                answer++;
            }
        }

        System.out.println(answer);

    }

    static int getPrimeLength(int num) {
        int count = 0;
        int i = 2;
        while (num >= i) {
            if (num % i == 0) {
                num /= i;
                count++;
                continue;
            }
            i++;
        }

        return count;
    }

    static void getPrime(int num) {
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= num; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

}
