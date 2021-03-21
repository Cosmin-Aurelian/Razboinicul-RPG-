package Razboinicul;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();

       //Statusuri Inamici
        String[] inamici= {"Gladiator","Assassin","Magician","Boxeor","Lup","Urs","Arcas","Mistret"};
        int ViataMaximaInamic =100;
        int AttackDamageInamic=30;

        //Statusuri Razboinic
        int Viata=120;
        int AttackDamage= 30;
        int NumarPotiuni=3;
        int ViataPerPotiune=35;
        int SansaDropPotiune=50;

        boolean joc=true;

        System.out.println("Bun venit in temnita Razboinicule");
        InceputJOC:
        while(joc)
        {
            System.out.println("------------------------------------------------------------");
            int ViataInamic=random.nextInt(ViataMaximaInamic);
            String inamic= inamici[random.nextInt(inamici.length)];
            System.out.println("\t# Te vei lupta cu un " +inamic+" #\n");

            while(ViataInamic>0)
            {
                System.out.println("\t Viata Razboinic: "+Viata );
                System.out.println("\t"+" Viata "+inamic+": "+ViataInamic);
                System.out.println("\n\t Optiuni");
                System.out.println("\t1. Atac");
                System.out.println("\t2. Utilizare Potiune");
                System.out.println("\t3. Fugi!");

                String scrie=scanner.nextLine();
                if(scrie.equals("1"))
                {
                int LovituriProvocate= random.nextInt(AttackDamage);
                int LovituriPrimite= random.nextInt(AttackDamageInamic);
                Viata-=LovituriPrimite;
                ViataInamic-=LovituriProvocate;

                    System.out.println("\t> Ai lovit "+inamic+"ul si ai provocat "+LovituriProvocate+" daune per lovitura");
                    System.out.println("\t> Ai incasat de la "+inamic+" "+LovituriPrimite+" daune");
                    if(Viata<1)
                    {
                        System.out.println("\nAi incasat prea multe lovituri si nu mai poti continua lupta");
                        break;
                    }
                }
                else if(scrie.equals("2"))
                {
                    if(NumarPotiuni>0)
                    {
                        Viata+=ViataPerPotiune;
                        NumarPotiuni--;
                        System.out.println("\t> Ai utilizat o potiune. Vindecare in valoare de "+ViataPerPotiune+" . "
                                            + "\n\t> Acum ai "+Viata+" viata."
                                            + "\n\t> Ti-au mai ramas "+ NumarPotiuni+ "potiuni.");
                    }
                    else
                    {
                        System.out.println("\t> Nu mai ai potiuni ramase! Invinge inamicii pentru a avea sansa sa dropeze una");
                    }
                }
                else if(scrie.equals("3"))
                {
                    System.out.println(" Ai ales sa fugi de "+inamic+ "!");
                    continue InceputJOC;
                }
                else
                {
                    System.out.println("\t Comanda Invalida");
                }
            }
            if(Viata< 1)
            {
                System.out.println("Esti prea slabit pentru Temnita");
                break;
            }
            System.out.println("------------------------------------------------------------");
            System.out.println(" # "+ inamic+ "ul a fost invins! # ");
            System.out.println(" # "+ Viata + " viata ramasa. #");
            if(random.nextInt(100)< SansaDropPotiune)
            {
                NumarPotiuni++;
                System.out.println(" # "+inamic+"ul a dropat o potiune! #");
                System.out.println(" # Acum ai "+ NumarPotiuni+ " potiuni ramase");
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("Ce vei alege in continuare?");
            System.out.println("1. Continui sa avansezi in Temnita");
            System.out.println("2. Iesi din Temnita");

            String scrie=scanner.nextLine();

            while(!scrie.equals("1")&& !scrie.equals("2"))
            {
                System.out.println("Comanda Invalida");
                scrie=scanner.nextLine();
            }
            if(scrie.equals("1"))
            {
                System.out.println("Iti continui aventura!");
            }
            else if(scrie.equals("2"))
            {
                System.out.println("Ai iesit din Temnita");
                break;
            }

        }
        System.out.println("##########################");
        System.out.println("# Multumim ca ati jucat! #");
        System.out.println("##########################");

    }
}
