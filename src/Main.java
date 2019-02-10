import DAO.CategoryDAO;
import DAO.TemplateDAO;
import service.ZorgeDataRetrieve;

public class Main {
    public static void main(String[] args) {
        ZorgeDataRetrieve zorgeDataRetrieve = new ZorgeDataRetrieve();
        //zorgeDataRetrieve.getTemplates();
        //zorgeDataRetrieve.getCategories();
        //CategoryDAO.insertCategories(zorgeDataRetrieve.getCategories());
        TemplateDAO.insertTemplates(zorgeDataRetrieve.getTemplates());
    }
}
