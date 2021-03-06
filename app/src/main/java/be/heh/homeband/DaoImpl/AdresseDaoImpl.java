package be.heh.homeband.DaoImpl;

import java.util.List;

import be.heh.homeband.Dao.AdresseDao;
import be.heh.homeband.entities.Adresse;
import be.heh.homeband.entities.Evenement;

public class AdresseDaoImpl  extends DaoImpl implements AdresseDao {
    @Override
    public Adresse get(Integer id) {
        Adresse result = realm.where(Adresse.class)
                .equalTo("id_adresses",id)
                .findFirst();
        if (result != null){
            return realm.copyFromRealm(result);
        }
        
        return null;
    }

    @Override
    public List<Adresse> list() {
        return realm.copyFromRealm(realm.where(Adresse.class).findAll()) ;
    }

    @Override
    public void delete(Integer id) {
        realm.beginTransaction();
        Adresse result = realm.where(Adresse.class)
                .equalTo("id_adresses",id)
                .findFirst();
        if (result != null){
            result.deleteFromRealm();
        }
        realm.commitTransaction();
    }

    @Override
    public Adresse write(Adresse obj) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(obj);
        realm.commitTransaction();
        return obj;
    }
}
