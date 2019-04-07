package principale.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import principale.entity.Prodotto;
import principale.entity.ScontrinoT;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-07T20:49:50")
@StaticMetamodel(ScontrinoR.class)
public class ScontrinoR_ { 

    public static volatile SingularAttribute<ScontrinoR, Double> prezzoVL;
    public static volatile SingularAttribute<ScontrinoR, Integer> id;
    public static volatile SingularAttribute<ScontrinoR, ScontrinoT> testa;
    public static volatile SingularAttribute<ScontrinoR, Prodotto> prodotto;
    public static volatile SingularAttribute<ScontrinoR, Integer> qta;

}