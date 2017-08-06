/**
 * Created by eig on 02/08/17.
 */
public class KthPrimeFactor
{

    static int kthprimeFactor(int n, int k)
    {
        if (k == 1)
        {
            return 1;
        }
        while (n % 2 == 0)
        {
            if (k == 2)
            {
                return 2;
            }

            k--;
            n = n / 2;

        }
        for (int i = 3; i < Math.sqrt(n); i += 2)

        {
            while (n % i == 0)
            {
                if (k == 2)
                {
                    return i;
                }
                k--;
                n = n / i;
            }
        }

        if (n > 2 && k == 2)
        {
            return n;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(kthprimeFactor(81,9));
    }
}
//1,2,5,10