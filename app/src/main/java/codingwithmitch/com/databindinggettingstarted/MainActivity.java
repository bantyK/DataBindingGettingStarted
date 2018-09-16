package codingwithmitch.com.databindinggettingstarted;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import codingwithmitch.com.databindinggettingstarted.databinding.ActivityMainBinding;
import codingwithmitch.com.databindinggettingstarted.listeners.AddToCartClickListener;
import codingwithmitch.com.databindinggettingstarted.listeners.ChooserDialogListener;
import codingwithmitch.com.databindinggettingstarted.models.Product;
import codingwithmitch.com.databindinggettingstarted.util.Products;

public class MainActivity extends AppCompatActivity implements ChooserDialogListener, AddToCartClickListener {

    //data binding
    ActivityMainBinding mBinding;
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Products products = new Products();
        mProduct = products.PRODUCTS[2];

        mBinding.setProduct(mProduct);
        mBinding.setQuantity(1);
        mBinding.setChooserDialogListener(this);
        mBinding.setAddToCartClickListener(this);
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(),
                getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }

    @Override
    public void addToCartClicked(String title) {
        Toast.makeText(this, title + " added to cart", Toast.LENGTH_SHORT).show();
    }
}
