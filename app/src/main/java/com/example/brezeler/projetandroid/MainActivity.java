package com.example.brezeler.projetandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DAO.FavoriDAO;
import DAO.ItemDAO;
import DAO.UsersDAO;
import Model.Favori;
import Model.Item;
import Model.Users;
import Parseur.Parseur;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*//Test okai !
        Users user = new Users("a@hot.fr", "toto", "NAME", "see");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dueDate = null;
        try {
            dueDate = dateFormat.parse("1999-12-07 12:30:03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Item item = new Item("lien","title",dueDate, "popo","source","description");
        ItemDAO itemDAO = new ItemDAO(this);
        UsersDAO usersDAO = new UsersDAO(this);
        FavoriDAO favoriDAO = new FavoriDAO(this);
        usersDAO.open();
        itemDAO.open();
        favoriDAO.open();
        usersDAO.add(user);
        itemDAO.add(item);
        favoriDAO.addFavori(item.getId(),user.getEmail());
        TextView textView = (TextView)findViewById(R.id.sisi);
        ArrayList<Item> tabitem = favoriDAO.getFavori(user.getEmail());
        textView.setText(tabitem.get(0).getTitle());
        usersDAO.close();
        itemDAO.close();
        favoriDAO.close();*/
        Parseur parseur = new Parseur();
        ArrayList<Item> entries = parseur.parseur("<rss xmlns:atom=\"http://www.w3.org/2005/Atom\" version=\"2.0\">\n" +
                "<channel>\n" +
                "<title>Le Monde.fr - Actualité à la Une</title>\n" +
                "<description>\n" +
                "Le Monde.fr - 1er site d'information. Les articles du journal et toute l'actualité en continu : International, France, Société, Economie, Culture, Environnement, Blogs ...\n" +
                "</description>\n" +
                "<copyright>Copyright Le Monde.fr</copyright>\n" +
                "<link>http://www.lemonde.fr/rss/une.xml</link>\n" +
                "<atom:link href=\"http://www.lemonde.fr/rss/une.xml\" rel=\"self\" type=\"application/rss+xml\"/>\n" +
                "<pubDate>Tue, 19 Jul 2016 16:58:20 +0200</pubDate>\n" +
                "<image>\n" +
                "<url>\n" +
                "http://www.lemonde.fr/mmpub/img/lgo/lemondefr_rss.gif\n" +
                "</url>\n" +
                "<title>Le Monde.fr - Actualité à la Une</title>\n" +
                "<link>http://www.lemonde.fr/rss/une.xml</link>\n" +
                "</image>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/idees/article/2016/07/19/apres-nice-comment-debattre_4971771_3232.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Après l’attentat de Nice, le risque de la surenchère électoraliste\n" +
                "</title>\n" +
                "<description>\n" +
                "Editorial. S’il est sain que le débat politique porte sur les attentats et la sécurité des Français en général, il y a des propos qui relèvent de l’électoralisme pur et simple et sont, en l’espèce, pour le moins déplacés.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 11:44:59 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971771/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971770_3_434b_eric-ciotti-christian-estrosi-et-manuel-valls_9beb2dae68e451c23fa3a61dab66e8a5.jpg\" type=\"image/jpeg\" length=\"50169\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/societe/article/2016/07/19/attentats-les-associations-de-victimes-reclament-un-changement-dans-la-politique-d-indemnisation_4971624_3224.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Attentat de Nice : l’Etat promet d’indemniser rapidement les victimes\n" +
                "</title>\n" +
                "<description>\n" +
                "Les premières aides financières seront versées « dès la fin de la semaine », selon le secrétariat d’Etat chargé de l’aide aux victimes. De leur côté, les associations demandent plus d’efficacité.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 09:51:45 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971624/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971621_3_b1b9_a-nice-84-personnes-sont-mortes-des-centaines_6bef12a8bfff371a02f5d216229b7cb6.jpg\" type=\"image/jpeg\" length=\"108089\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/les-decodeurs/article/2016/07/18/terrorisme-le-gouvernement-n-a-t-il-vraiment-rien-fait-depuis-deux-ans_4971496_4355770.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Terrorisme : le gouvernement n’a-t-il vraiment rien fait depuis deux ans ?\n" +
                "</title>\n" +
                "<description>\n" +
                "L’opposition dénonce l’inaction du gouvernement, qui a pourtant multiplié les initiatives antiterroristes depuis le début du quinquennat.\n" +
                "</description>\n" +
                "<pubDate>Mon, 18 Jul 2016 19:41:46 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971496/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971530_3_7ae1_marisol-touraine-philippe-pradal-adolphe_fc055f8439879a1db55285039138e8e4.jpg\" type=\"image/jpeg\" length=\"55829\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/politique/article/2016/07/19/attentat-de-nice-valls-demande-a-estrosi-de-se-reprendre_4971751_823448.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Attentat de Nice : Valls demande à Estrosi de « se reprendre »\n" +
                "</title>\n" +
                "<description>\n" +
                "Le premier ministre répond aux accusations mardi dans « Nice-Matin » aux accusations du président LR de la région PACA.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 11:35:32 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971751/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971750_3_10ae_le-prefet-des-alpes-maritimes-adolphe-colrat_c4427c0a2fa944df8b32d587cd53c20c.jpg\" type=\"image/jpeg\" length=\"44022\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/societe/article/2016/07/19/la-douleur-des-parents-de-yanis-4-ans-et-demi-tue-le-14-juillet-a-nice_4971734_3224.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "La douleur des parents de Yanis, 4 ans, tué le 14 juillet à Nice\n" +
                "</title>\n" +
                "<description>\n" +
                "La famille s’était installée il y a trois ans. Depuis l’attentat, ils se rendent chaque jour là où leur fils est tombé.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 11:24:09 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971734/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971733_3_c884_lundi-18-juillet-la-promenade-des-anglais_4edaa1694429c4f9043d98f25d1709b6.jpg\" type=\"image/jpeg\" length=\"27470\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/politique/article/2016/07/19/etat-d-urgence-le-gouvernement-se-veut-ouvert-aux-propositions-de-la-droite_4971808_823448.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Etat d’urgence : le gouvernement prêt à étudier une prolongation de six mois\n" +
                "</title>\n" +
                "<description>\n" +
                "Il est possible de trouver un accord sur la durée de l’allongement de l’état d’urgence, a affirmé le porte-parole du gouvernement, Stéphane Le Foll, à l’issue du conseil des ministres.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 13:04:07 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971808/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971806_3_792f_le-porte-parole-du-gouvernement-stephane-le_f0203e2c134f98724cef8a34296a6050.jpg\" type=\"image/jpeg\" length=\"35794\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/societe/article/2016/07/18/laura-sean-rachel-yanis-qui-sont-les-victimes-de-l-attentat-de-nice_4971465_3224.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Laura, Sean, Rachel, Yanis… qui sont les victimes de l’attentat de Nice ?\n" +
                "</title>\n" +
                "<description>\n" +
                "Les 84 personnes tuées dans l’attentat de Nice le 14 juillet ont été formellement identifiées, a annoncé le parquet de Paris.\n" +
                "</description>\n" +
                "<pubDate>Mon, 18 Jul 2016 18:19:05 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971465/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/18/644x322/4971464_3_316c_des-fleurs-et-des-bougies-sur-la-promenade-des_55c6454a8f3c9afe417e358e04c49c4a.jpg\" type=\"image/jpeg\" length=\"80657\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/economie/article/2016/07/19/apres-le-brexit-le-fmi-revoit-ses-previsions-de-croissance-mondiale-a-la-baisse_4971838_3234.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Après le Brexit, le FMI prévoit une croissance mondiale à la baisse\n" +
                "</title>\n" +
                "<description>\n" +
                "Selon les scénarios, les incertitudes liées au référendum britannique pourraient coûter 0,1 à 0,7 point à la croissance mondiale en 2017.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 15:05:34 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971838/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971836_3_a676_la-ville-de-port-talbot-dans-le-sud-du-pays-de_0712b269a91d7015ba75ae18f24b15a5.jpg\" type=\"image/jpeg\" length=\"38870\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/europe/article/2016/07/18/allemagne-attaque-a-la-hache-dans-un-train-plusieurs-blesses_4971507_3214.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Allemagne : dans une vidéo, l’auteur de l’attaque dit agir au nom de l’EI\n" +
                "</title>\n" +
                "<description>\n" +
                "Un Afghan de 17 ans, qui s’est présenté comme un « soldat de l’Etat islamique », a fait quatre blessés graves dans un train, lundi soir en Bavière.\n" +
                "</description>\n" +
                "<pubDate>Mon, 18 Jul 2016 23:48:25 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971507/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971879_3_123e_un-jeune-afghan-de-17-ans-qui-s-est-p_e5f9fd0b1325dcc83709a11d60e8b78d.jpg\" type=\"image/jpeg\" length=\"77945\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/festival/visuel/2016/07/18/ceuxquifont-dans-la-haute-vienne-un-village-ressuscite-par-la-volonte-de-sa-maire_4971155_4415198.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "#CeuxQuiFont Dans la Haute-Vienne, un village ressuscité par sa maire\n" +
                "</title>\n" +
                "<description>\n" +
                "Face au pessimisme ambiant, ils font bouger la société. Cette semaine, Christine de Neuville, maire de Vicq-sur-Breuilh (Haute-Vienne), qui a redynamisé ce petit village limousin menacé d’abandon.\n" +
                "</description>\n" +
                "<pubDate>Mon, 18 Jul 2016 11:01:16 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971155/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/18/644x322/4971153_3_5220_christine-de-neuville-a-vicq-sur-breuil_d77f78b3804d4d8c7a1c0b33c37e2f17.jpg\" type=\"image/jpeg\" length=\"61589\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/europe/article/2016/07/19/apres-le-coup-d-etat-bruxelles-joue-les-equilibristes-face-a-la-turquie_4971533_3214.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Bruxelles joue les équilibristes face à la Turquie après le putsch\n" +
                "</title>\n" +
                "<description>\n" +
                "Reprise des négociations sur l’adhésion, extradition de Fethullah Gülen, suppression des visas : les discussions de l’Europe avec Ankara sont périlleuses.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 06:40:29 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971533/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971576_3_420b_a-pro-erdogan-supporter-waves-a-turkish_3f15de0b8d499aab5f2e43e0367b5466.jpg\" type=\"image/jpeg\" length=\"22010\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/pixels/article/2016/07/19/pokemon-go-est-il-compatible-avec-l-etat-d-urgence_4971878_4408996.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "« Pokémon GO » est-il soluble dans l’état d’urgence ?\n" +
                "</title>\n" +
                "<description>\n" +
                "Le jeu consiste à se lancer, de préférence dehors, à la recherche de créatures fantastiques virtuelles cachées dans le monde réel, et cette chasse peut être collective. Ce qui peut poser la question de la sécurité.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 16:30:04 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971878/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971876_3_f31f_des-joueurs-de-pokemon-go-reunis-dans-un-j_d86ba147e337862477ec981c1ff3f336.jpg\" type=\"image/jpeg\" length=\"76940\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/police-justice/article/2016/07/19/nouveau-record-du-nombre-de-detenus-au-1er-juillet-avec-69-375-personnes-incarcerees_4971827_1653578.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Nouveau record du nombre de détenus en France, avec 69 375 personnes incarcérées\n" +
                "</title>\n" +
                "<description>\n" +
                "Les nouveaux chiffres publiés par l’administration pénitentiaire du nombre de détenus écroués au 1er juillet présente une croissance de 1,2 % sur un mois et de 3,8 % sur un an.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 14:47:33 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971827/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971834_3_10d7_les-nouveaux-chiffres-publies-par_06f3d2c9a2a9737477fb9593aae7d605.jpg\" type=\"image/jpeg\" length=\"20467\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/economie/article/2016/07/19/apple-passe-a-l-offensive-sur-le-marche-du-paiement-mobile-en-france_4971740_3234.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Apple passe à l’offensive sur le marché du paiement mobile en France\n" +
                "</title>\n" +
                "<description>\n" +
                "Avec Apple Pay, lancé en France mardi, le groupe espère doper ses ventes de téléphones.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 11:26:30 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971740/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971739_3_2478_demonstration-de-l-apple-pay_1fa5cb8d7efe1b4da6bbe8ba759cb797.jpg\" type=\"image/jpeg\" length=\"30334\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/politique/article/2016/07/19/loi-travail-le-texte-en-nouvelle-lecture-au-senat-avant-son-adoption-definitive_4971854_823448.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Loi travail : le texte en nouvelle lecture au Sénat avant son adoption définitive\n" +
                "</title>\n" +
                "<description>\n" +
                "Le texte devait être rejeté au Sénat mardi sans même être débattu par la majorité de droite.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 15:39:31 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971854/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971852_3_f386_discours-de-la-ministre-du-travail-myriam-el_47a0f8577856afaa569c01bd966d28b6.jpg\" type=\"image/jpeg\" length=\"75259\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/m-perso/article/2016/07/19/a-villeneuve-sur-lot-l-exode-urbain-en-vitrine_4971670_4497916.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "A Villeneuve-sur-Lot, l’exode urbain s’affiche en vitrine\n" +
                "</title>\n" +
                "<description>\n" +
                "Dans la sous-préfecture du Lot-et-Garonne, nombre de commerces du centre-ville ont définitivement baissé le rideau. Avec l’aide des habitants, la photographe Stéphanie Lacombe a redonné vie à ces vitrines, le temps d’une prise de vue.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 10:12:46 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971670/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971666_3_7a34_la-poissonnerie-gourc-fermee-depuis-2006-rue_475910449cb3411da15f6cdcf3ec3913.jpg\" type=\"image/jpeg\" length=\"62016\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/politique/article/2016/07/19/la-cour-des-comptes-salue-les-efforts-de-l-elysee-pour-maitriser-ses-depenses_4971807_823448.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "La Cour des comptes salue les efforts de l’Elysée pour maîtriser ses dépenses\n" +
                "</title>\n" +
                "<description>\n" +
                "Une semaine après la polémique sur le montant du salaire du coiffeur du président, la Cour des comptes constate un résultat positif de 3,21 millions d’euros dans les comptes de l’Elysée.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 13:04:00 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971807/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971805_3_0438_une-semaine-apres-la-polemique-sur-le-montant-d_29d48148cac5d162d8fc1659cde472b5.jpg\" type=\"image/jpeg\" length=\"45750\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/campus/article/2016/07/19/l-unef-denonce-la-selection-illegale-a-l-universite_4971687_4401467.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "L’UNEF dénonce la sélection illégale à l’université\n" +
                "</title>\n" +
                "<description>\n" +
                "Selon le syndicat étudiant majoritaire, quatre universités sur cinq pratiquent une sélection à l’entrée de certaines licences. Illégalement.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 10:27:42 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971687/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971686_3_5d7c_selon-l-unef-60-universites-pratiquent-une-se_85e94eef85fb1b2398e7c803bf3b7d91.png\" type=\"image/png\" length=\"477255\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/entreprises/article/2016/07/19/bruxelles-ouvre-une-enquete-sur-le-financement-de-la-restructuration-d-areva-par-la-france_4971869_1656994.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Bruxelles ouvre une enquête sur le financement de la restructuration d’Areva par la France\n" +
                "</title>\n" +
                "<description>\n" +
                "La Commission a précisé qu’elle devait « examiner attentivement si son plan de restructuration est solide et si les aides d’Etat ne faussent pas indûment la concurrence dans le marché unique ».\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 16:23:11 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971869/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971867_3_92ef_logo-d-areva-au-bourget-en-juin-2016_47e59405055e673d3e94c045aafa5db3.jpg\" type=\"image/jpeg\" length=\"22907\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/jeux-olympiques-rio-2016/article/2016/07/19/avant-les-jo-un-nouveau-rapport-confirme-l-etendue-du-dopage-d-etat-en-russie_4971539_4910444.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "JO : accusée de « dopage d’Etat », la Russie bientôt hors-jeu ?\n" +
                "</title>\n" +
                "<description>\n" +
                "Le Comité international olympique, qui se réunit aujourd’hui, pourrait exclure la Russie des JO de Rio (5-21 août) après la publication d’un nouveau rapport accablant\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 06:42:08 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971539/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971538_3_2636_les-anneaux-olympiques-durant-les-jeux-de_b2fb4203b1e87f1e358234851d487aa6.jpg\" type=\"image/jpeg\" length=\"52912\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/elections-americaines/article/2016/07/19/presidentielle-americaine-j-111-la-convention-de-cleveland-reduit-au-silence-les-anti-trump_4971782_829254.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Présidentielle américaine, J-111 : la convention de Cleveland réduit au silence les anti-Trump\n" +
                "</title>\n" +
                "<description>\n" +
                "De Melania Trump qui plagie un discours de Michelle Obama à Hillary Clinton qui détourne un vieux tweet Rudy Giuliani, l’essentiel de la campagne américaine.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 11:50:08 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971782/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971775_3_e3df_un-delegue-republicain-a-la-convention-de-clev_c6d13e48ba43d07473c389cbd4723d81.jpg\" type=\"image/jpeg\" length=\"53936\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/afrique/article/2016/07/19/bill-gates-les-jeunes-africains-doivent-pouvoir-etre-les-artisans-de-leur-prosperite_4971630_3212.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "Bill Gates : « Les jeunes Africains doivent pouvoir être les artisans de leur prospérité »\n" +
                "</title>\n" +
                "<description>\n" +
                "Dans une tribune exclusive pour « Le Monde Afrique », l’ancien PDG de Microsoft rappelle son ambition pour le continent et sa jeunesse.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 09:53:42 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971630/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2016/07/19/644x322/4971629_3_8b52_des-jeunes-garcons-s-entrainent-au-skate-a-nair_f7bd9a3e1803dc36e113d021c74cbcff.jpg\" type=\"image/jpeg\" length=\"37577\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/tour-de-france/article/2016/07/19/tour-de-france-des-equipes-en-quete-d-identite_4971684_1616918.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>Tour de France : des équipes en quête d’identité</title>\n" +
                "<description>\n" +
                "D’un Tour à l’autre, les formations changent de noms comme de sponsors. De quoi perdre les spectateurs.\n" +
                "</description>\n" +
                "<pubDate>Tue, 19 Jul 2016 10:26:05 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4971684/</guid>\n" +
                "<enclosure url=\"http://s1.lemde.fr/image/2016/07/19/644x322/4971683_3_e04f_alexis-vuillermoz-au-depart-de-la-3e-etape-l_b9b28a7362266fab28cd13d45d832246.jpg\" type=\"image/jpeg\" length=\"56097\"/>\n" +
                "</item>\n" +
                "<item>\n" +
                "<link>\n" +
                "http://www.lemonde.fr/les-decodeurs/article/2015/07/01/a-quelles-temperatures-peut-on-parler-de-canicule_4665560_4355770.html#xtor=RSS-3208\n" +
                "</link>\n" +
                "<title>\n" +
                "A quelles températures peut-on parler de « canicule » ?\n" +
                "</title>\n" +
                "<description>\n" +
                "Les seuils de canicule, selon les températures observées le jour et la nuit, sont différents selon les départements.\n" +
                "</description>\n" +
                "<pubDate>Wed, 01 Jul 2015 08:09:58 +0200</pubDate>\n" +
                "<guid isPermaLink=\"true\">http://www.lemonde.fr/tiny/4665560/</guid>\n" +
                "<enclosure url=\"http://s2.lemde.fr/image/2015/07/01/644x322/4665694_3_03a9_la-carte-des-seuils-caniculaires-en-france_d148b0fcb61f6e6930e14053e8e54b04.png\" type=\"image/png\" length=\"190643\"/>\n" +
                "</item>\n" +
                "</channel>\n" +
                "</rss>");
        TextView textView = (TextView)findViewById(R.id.sisi);
        textView.setText("Test en cour");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
