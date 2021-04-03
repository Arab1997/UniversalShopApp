package uz.group.anticor.view.adapter

import android.view.View
import kotlinx.android.synthetic.main.product_item_layout.view.*
import uz.group.anticor.App
import uz.group.anticor.R
import uz.group.anticor.base.loadImage
import uz.group.anticor.model.ProductModel

interface ProductsAdapterListener: BaseAdapterListener{
    fun getPage(index: Int)
}

class ProductsAdapter(var list: List<ProductModel>, val handler: ProductsAdapterListener): BaseAdapter(list.toMutableList(), R.layout.product_item_layout, handler){
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem<ProductModel>(position)
        holder.itemView.tvTitle.text = item.name
        holder.itemView.imgProduct.loadImage(App.imageBaseUrl + item.image)

        if (item.cartCount > 0){
            holder.itemView.imgPlus.visibility = View.GONE
            holder.itemView.textViewCartCount.visibility = View.VISIBLE
            holder.itemView.textViewCartCount.text = item.cartCount.toString()
        }else{

            holder.itemView.imgPlus.visibility = View.VISIBLE
            holder.itemView.textViewCartCount.visibility = View.GONE
        }
    }

    fun updateItems(items: List<ProductModel>){
        this.list = items
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }
}