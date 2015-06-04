package mlplanets.dao.impl;

import mlplanets.dao.PredictionDAO;
import mlplanets.domain.Prediction;
import mlplanets.domain.SolarSystem;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class PredictionDAOImpl extends AbstractDAO<Prediction> implements PredictionDAO {

    public Long getLastPredictedDay(SolarSystem solarSystem) {

        return (Long) getAttachedCriteria()
                .add(Restrictions.eq("solarSystem", solarSystem))
                .setProjection(Projections.max("day"))
                .uniqueResult();
    }
}