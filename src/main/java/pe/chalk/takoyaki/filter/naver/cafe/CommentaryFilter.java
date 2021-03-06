/*
 * Copyright 2014-2015 ChalkPE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pe.chalk.takoyaki.filter.naver.cafe;

import org.jsoup.nodes.Document;
import pe.chalk.takoyaki.target.NaverCafe;
import pe.chalk.takoyaki.model.naver.cafe.SimpleArticle;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2015-04-07
 */
public class CommentaryFilter extends NaverCafeFilter<SimpleArticle> {
    public static final String NAME = "naver.cafe.commentary";

    public CommentaryFilter(NaverCafe target){
        super(target);
    }

    @Override
    public String getName(){
        return NAME;
    }
    
    @Override
    public String getPrefix(){
        return "덧글";
    }

    @Override
    public List<SimpleArticle> filter(Document[] documents){
        return documents[0].select("#recent-reply .ellipsis.tcol-c").stream()
                .map(element -> {
                    String commentCountAttr = element.parent().attr("title");
                    String articleIdAttr = element.parent().attr("href");

                    int commentCount = Integer.parseInt(commentCountAttr.substring(commentCountAttr.lastIndexOf("덧") + 1));
                    int id = Integer.parseInt(articleIdAttr.substring(articleIdAttr.lastIndexOf('=') + 1));
                    String title = element.text();

                    return new SimpleArticle(this.getTarget(), id, title, commentCount);
                })
                .collect(Collectors.toList());
    }
}