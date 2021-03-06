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
import pe.chalk.takoyaki.filter.Filter;
import pe.chalk.takoyaki.target.NaverCafe;
import pe.chalk.takoyaki.model.Data;

/**
 * @author ChalkPE <chalkpe@gmail.com>
 * @since 2015-04-16
 */
public abstract class NaverCafeFilter<T extends Data> extends Filter<Document[], T> {
    public static final String NAME = "naver.cafe.abstract";

    public NaverCafeFilter(NaverCafe target){
        super(target);
    }

    @Override
    public String getName(){
        return NAME;
    }
}