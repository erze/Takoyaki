package pe.chalk.takoyaki.filter.namu.wiki;

import org.json.JSONArray;
import org.json.JSONObject;
import pe.chalk.takoyaki.Takoyaki;
import pe.chalk.takoyaki.filter.Filter;
import pe.chalk.takoyaki.model.namu.wiki.Document;
import pe.chalk.takoyaki.target.Target;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2015-10-31
 */
public class StatusFilter extends Filter<JSONArray, Document> {
    public StatusFilter(Target<JSONArray> target){
        super(target);
    }

    @Override
    public List<Document> filter(JSONArray array){
        return Takoyaki.<JSONObject>buildStream(array).map(doc -> Document.create(this.getTarget(), doc)).collect(Collectors.toList());
    }

    @Override
    public String getPrefix(){
        return "최근 변경";
    }
}
