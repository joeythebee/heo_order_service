select * From O_Lov Where List_Of_Values_Seq In 
 (
 	select Allowed_Val_Seq From O_Item_Prompt Where Order_Item_Seq= ?
  	union select recommended_val_seq from O_item_prompt where Order_item_seq = ?
 )
order by list_of_values_seq, disp_seq