[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SectionedRecyclerViewAdapter-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1783)

# SectionedRecyclerViewAdapter

## About
A recyclerView adapter to add sectionned headers

This library is an adaptation of (https://github.com/ragunathjawahar/simple-section-adapter) to be used with a RecyclerView.

## Usage
```Java
//create an adapter
Youradapter adapter = new Youradapter();
SectionedRecyclerViewAdapter  mSectionedAdapter  = new    SectionedRecyclerViewAdapter(this,R.layout.layout_list_creative_header,R.id.textViewTitleHeaderListCreative,new Youradapter(), this);
mSectionedAdapter.setSections(listCreativeObjects);//the list object do you use

recyclerView.setAdapter(mSectionedAdapter);

//implement a sectionizer (you can do it in your adapter)
@Override
public String getSectionTitle(Object object) {
   return (object).titleSection;
}

//get the item position clicked
because we add items to the adapter the position  with onClick is not te real position of the element
use :
mSectionedAdapter.getIndexForPosition(position);


```

![screenshot of the result](https://github.com/AndroFlo/SectionedRecyclerViewAdapter/blob/master/screenshots/screenshot_sample.png)

License
=======
Copyright 2015 Audigué Florian

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
