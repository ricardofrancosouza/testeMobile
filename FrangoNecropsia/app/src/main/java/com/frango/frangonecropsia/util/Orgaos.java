package com.frango.frangonecropsia.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ricar on 10/12/2017.
 */

public class Orgaos {
    private HashMap<String,List<String>> orgaoMap;
    public Orgaos(){
     this.orgaoMap = new HashMap<>();
     popularOrgaoMap();
    }

    public HashMap<String, List<String>> getOrgaoMap() {
        return orgaoMap;
    }

    public void setOrgaoMap(HashMap<String, List<String>> orgaoMap) {
        this.orgaoMap = orgaoMap;
    }

    private void popularOrgaoMap() {
        this.orgaoMap.put("PROVENTRICULO",new ArrayList<String>(){{
            add(" Proventrículo - Normal");
            add("Proventrículo com hemorragias / Proventrículo com úlceras");
        }});
        this.orgaoMap.put("INTESTINO", new ArrayList<String>(){{
            add("Intestino - Normal");
            add("Intestino com congestão");
            add("Intestino com hemorragia");
            add("Intestino com necrose");
            add("Intestino com congestão / Intestino com hemorragia");
            add("Intestino com congestão / Intestino com necrose");
            add("Intestino com hemorragia / Intestino com necrose");
            add("Intestino com congestão / Intestino com hemorragia / Intestino com necrose");
            add("Intestinos com nódulos");
            add("Intestinos granulomas");
            add("Intestinos com nódulos / Intestinos granulomas");
        }});
        this.orgaoMap.put("TRAQUEIA", new ArrayList<String>(){{
            add("Traqueia - Normal");
            add("Traqueia com exsudato catarral");
            add("Traqueia com congestão / Traqueia com hemorragia");
        }});
        this.orgaoMap.put("PULMOES", new ArrayList<String>(){{
            add("Pulmões - Normal");
            add("Pulmões com nodulações");
            add("Pulmões Focos necróticos(focos brancos)");
            add("Pulmões com consolidação de parênquima");
            add("Pulmões com nodulações / Pulmões Focos necróticos(focos brancos)");
        }});

        this.orgaoMap.put("SACOS AEREOS", new ArrayList<String>(){{
            add("Sacos aéreos - Normal");
            add("Sacos aéreos opacos");
            add("Sacos aéreos com exsudato fibrino purulento");
            add("Sacos aéreos com nodulações");
            add("Sacos aéreos opacos / Sacos com exsudato fibrino purulento");
            add("Sacos aéreos opacos / Sacos aéreos com nodulações");
            add("Sacos aéreos com nodulações/Sacos aéreos com nodulações");
            add("Sacos aéreos opacos / Sacos aéreos com nodulações / Sacos aéreos com nodulações");
        }});

        this.orgaoMap.put("CLOACA", new ArrayList<String>(){{
            add("CLOACA - Normal");
            add("CLOACA - Pintos com tamponamento fecal esbranquiçado, preso a cloaca");
        }});

        this.orgaoMap.put("FIGADO", new ArrayList<String>(){{
            add("Fígado - Normal");
            add("Fígado aumentado de volume");
            add("Figado congesto");
            add("Figado com cor amarronzada");
            add("Figado com consistência friável");
            add("Fígado com focos necróticos (focos brancos )");
            add("Fígado aumentado de volume / Figado congesto");
            add("Fígado aumentado de volume / Figado com cor amarronzada");
            add("Fígado aumentado de volume / Figado com consistência friável");
            add("Fígado aumentado de volume / Fígado com focos necróticos (focos brancos )");
            add("Figado congesto / Figado com cor amarronzada");
            add("Figado congesto / Figado com consistência friável");
            add("Figado congesto / Fígado com focos necróticos (focos brancos )");
            add("Figado com cor amarronzada / Fígado com focos necróticos (focos brancos )");
            add("Figado com cor amarronzada / Figado com consistência friável");
            add("Fígado aumentado de volume / Figado congesto / Figado com cor amarronzada / Figado com consistência friável / Fígado com focos necróticos (focos brancos )");
        }});
    }

}
