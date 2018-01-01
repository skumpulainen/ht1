/* Harjoitustyö 1.
 *  
 * Lausekielinen ohjelmointi II, syksy 2016.
 *
 * Sara Kumpulainen 
 *
 *  Line Breaker.
 *                              
 */


public class LineBreaker {

   public static void main (String []args) {
      // Muuttujat koko ohjelmalle.
      boolean inputOK;
      String uusiRivi = "";
      boolean lauseRivitetty;
      int leveys = 0;
      String rivi = "";
      int pituus = 0;
      int ind =0;
      final char VALIT = ' ';
      final char KYLLA = 'y';
      final char EI = 'n';
      char vastaus;
      boolean TOTTA = true;
      final char KAUTTA ='/';
      final String ERROR = "Error!";

     
      System.out.println("Hello! I break lines.");
      // Tehdään koko ohjelmaa kunnes syöte ok, eli käyttäjä ei halua 
      // jatkaa.
      do{
      
         do{

            do {
              // Alueen leveys oltava suurempi kuin 2.
              System.out.println("Enter area width:");
              leveys = In.readInt();
              inputOK = leveys >2;

              if (!inputOK) {
                 System.out.println(ERROR);
              }
            }
            while (!inputOK);
  
            do{ 
            do{
               inputOK = true;
               // Pyydetään lausetta käyttäjältä.
               System.out.println("Enter a line:");
               rivi = In.readString();
               pituus = rivi.length();

               // Alustetaan nykyinen osa.
               int nykyisenOsanPituus =0;
               // Alustetaan haluttu pisin osa.
               int pisimmanOsanPituus =0;
               char nykyinenMerkki;
               //laskuri.
               ind =0;

               // Käydään läpi merkkejä niin kauan kun saavutettu
               // merkkijonon pituus.
               while (ind < rivi.length()) {
                 // Merkki päivittyy käydessä pituutta läpi.
                 nykyinenMerkki = rivi.charAt(ind);
                 // Jos merkki on välimerkki tai indeksi on saavuttanut
                 // merkkijonon pituuden..
                 if (nykyinenMerkki == VALIT || ind == rivi.length() -1) {
                   // Jos indeksi on saavuttanut merkkijonon
                   // pituuden
                   if (ind == rivi.length()-1) {
                     // ..lisätään nykyisen osan pituutta yhdellä...
                     nykyisenOsanPituus++;
                   }
                    
                 
                   // Jos nykyinen osa on suurempi kuin pisimmän
                   // osan pituus,
                   if (nykyisenOsanPituus> pisimmanOsanPituus) {
                     // Annetaan pisimmälle osalle nykyisen arvo...
                     pisimmanOsanPituus = nykyisenOsanPituus;
                     // ..onko suurempi kuin pisimmanOsanPituus?
                     //if (nykyisenOsanPituus > pisimmanOsanPituus) {
                     // sijoitetaan 
                     //pisimmanOsanPituus = nykyisenOsanPituus;
                     //}

                   }
                   nykyisenOsanPituus = 0;
                 }
                 else {
                 nykyisenOsanPituus++;
                 }
                 ind++;
    
                 }
                 if (pisimmanOsanPituus > leveys) {
                   inputOK = false;
                   System.out.println(ERROR);
                 } 
              }
              while (!inputOK);
                    
            

            
            do {
               // Katsotaan löytyykö merkkijonosta kahta peräkkäistä
               // välilyöntiä.
               // Tosi, jos merkkijono toistuu  
               boolean toistuu = false;
               
               // Jos merkkijono on suurempi kuin 2,
               // voidaan tarkastaa peräkkäisiä merkkejä.
               if (pituus > 1) {
                  ind = 0;
                  // Kun indeksi on pienempi kuin merkkijonon toiseksi 
                  // viimeinen kirjain 
                  while (ind < pituus -1) {
                     // Merkkien arvot.
                     char nykyinenMerkki = rivi.charAt(ind);
                     char seuraavaMerkki = rivi.charAt(ind+1); 
                     // Jos vierekkäiset merkit vastaavat välimerkkejä..
                     if (nykyinenMerkki == VALIT && seuraavaMerkki == VALIT) {
                        //..annetaan virheilmoitus.. 
                        inputOK = false;
                        System.out.println (ERROR);
                     }
                     // jos ei välejä, päivitetään ideksiä
                     // kunnes saavutettu pituus.
                     else {
                     ind++;
                     }
                  }
               }
            }
            // Kunnes annetaan merkkijono ilman tupla/triplavälejä. 
            while (!inputOK);


           //do {
            
               char ekaMerkki = rivi.charAt(0);
               char vikaMerkki = rivi.charAt(pituus -1);

               // Tarkastetaan onko ensimmäinen ja viimeinen merkki
               // välilyöntejä.
               if (ekaMerkki == VALIT || vikaMerkki == VALIT) {
                  inputOK = false;
                  System.out.println (ERROR);
               }

           }
            // Kunnes saavutetaan haluttu pituus.
            while (!inputOK);

          }
          // Kunnes syötteet OK.
          while (!inputOK);
          // Katkotaan lause.
          ind = 0;
          lauseRivitetty = false;
          int rivinPituus = rivi.length();
  
          do {
             // Oletetaan ettei lause ole vielä rivitetty loppuun.
             
             char nykyMerkki = rivi.charAt(ind);
             
             // Välimerkin arvo.
             int vikaVali =0;
             //  Niin kauan kun indeksi ei ole saavuttanut pituutta tai 
             // indeksi on pienempi tai yhtäsuuri kuin annettu leveys.
             while (ind < rivinPituus && ind <= leveys) {
                // Alustetaan ensimmäinen merkki.
                nykyMerkki = rivi.charAt(ind);
                // Jos ensimmäinen merkki on välimerkki..
                if (nykyMerkki == VALIT || ind == rivinPituus -1) {
                   //.. annetaan sille sen indeksiarvo.
                   // Saadaan ensimmäisen välin paikka.
                   vikaVali = ind;
                   if (ind == rivinPituus -1) {
                   vikaVali++;
                   }
                }
                // Jos merkki ei ole välimerkki, päivitetään indeksiä
                // jotta, päästään seuraavaan merkkiin.
                ind++;
             }

             // Alustetaan rivit tyhjiksi.
             String alkuRivi = "";
             String loppuRivi ="";


             // Lasketaan alku - ja loppurivit.
             for (int i = 0; i < vikaVali; i++) {
                alkuRivi =alkuRivi + rivi.charAt(i);
             }
             for (int b =(vikaVali+1); b < rivinPituus ; b++) {
                loppuRivi = loppuRivi + rivi.charAt(b);
             }
             // Tulostetaan rivit.
             System.out.print(alkuRivi); 

             for (int c = alkuRivi.length(); c < leveys; c++) {
                // Tulostetaan välit.
                System.out.print(VALIT);
             }
             //Tulostetaan sarkain.
             System.out.print(KAUTTA);
             System.out.println();
             // annetaan rivin arvoksi loppurivi.
             rivi = loppuRivi;
             rivinPituus = rivi.length();
             // Lause rivitetty jos loppurivin pituus 0.
             if (rivinPituus == 0) { 
                lauseRivitetty = true;
             }
             ind =  0;

           }
           while (!lauseRivitetty);
           
           boolean syoteOK = true;
           do {
             // Kysytään halutaanko jatkaa vai ei..
             System.out.println("Continue (y/n)?");
             vastaus = In.readChar();
             // Jos vastaus on joku muu kun 'y' tai 'n'
             if (vastaus != KYLLA && vastaus != EI) {
                // ja annetaan false-arvo jotta jatketaan keselyä.
                syoteOK = false;
               // Tulostetaan herjausviesti 
                System.out.println(ERROR);
             }
             else{
              syoteOK = true;
             }

           }
           while (!syoteOK);    
      }
      // Jos vastaus kyllä.
      while (vastaus == KYLLA);
      // Jos vastaus ei.
      System.out.println("See you soon.");
      
   }

}