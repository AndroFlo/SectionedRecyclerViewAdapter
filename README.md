# SectionedRecyclerViewAdapter
##About
A recyclerView adapter to add sectionned headers

This library is an adaptation of (https://github.com/ragunathjawahar/simple-section-adapter) to be used with a RecyclerView.

##Usage
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
