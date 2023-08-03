import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { LoginUserService } from './loginuser.services';
import { User } from './user';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'productmanagerapp';

  public products: Product[]=[];
  public editProduct!: Product;
  public deleteProduct!: Product;
  user: User;




  constructor(private productService: ProductService, private loginUserService: LoginUserService)
  {
    this.products = [];
    this.user = new User();
  }

  ngOnInit()
  {
    this.getProducts();
  }

  public getProducts(): void
  {
    this.productService.getAllProducts().subscribe((response: Product[])=>
    {
      this.products = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
  }

  public onAddProduct(addForm: NgForm): void{
    document.getElementById('add-product-form')?.click();
    this.productService.addProduct(addForm.value).subscribe(
      (response: Product) => {
        console.log(response);
        this.getProducts();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    )
  }

  public onUpdateProduct(product: Product): void{
  //  document.getElementById('add-product-form')?.click();
    this.productService.updateProduct(product).subscribe(
      (response: Product) => {
        console.log(response);
        this.getProducts();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }


  public onDeleteProduct(productId: number): void{
    //  document.getElementById('add-product-form')?.click();
      this.productService.deleteProduct(productId).subscribe(
        (response: void) => {
          console.log(response);
          this.getProducts();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      )
    }

    public searchProducts(key: string): void{
      console.log(key);
      const results: Product[] = [];
      for (const product of this.products){
        if ((product.description.toLowerCase().indexOf(key.toLowerCase()) !== -1)
       || product.ean.toLowerCase().indexOf(key.toLowerCase()) !== -1
       || product.generation.toLowerCase().indexOf(key.toLowerCase()) !== -1
       || product.type.toLowerCase().indexOf(key.toLowerCase()) !== -1)
        {
          results.push(product);
        }
        this.products = results;
        if (results.length == 0 || !key) {
          this.getProducts();
        }
      }

    }

  public onOpenModal(product: Product | null, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none'
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add')
    {
      button.setAttribute('data-target', '#addProductModal');
    }
    if (mode === 'edit' && product != null)
    {
        this.editProduct = product;
        button.setAttribute('data-target', '#updateProductModal');
    }
    if (mode === 'delete' && product != null)
    {
      this.deleteProduct = product;
          button.setAttribute('data-target', '#deleteProductModal');
    }
    container?.appendChild(button);
    button.click();
  }

  // initForm()
  // {
  //   this.formGroup = new FormGroup({
  //     email: new FormControl('', [Validators.required]),
  //     password: new FormControl('', [Validators.required])
  //   })
  // }

  // userLogin(){
  //   if (this.formGroup.valid){
  //     this.loginUserService.loginUser(this.formGroup.value).subscribe(result=>{
  //       if (result.success){
  //         console.log(result);
  //         alert(result.message);}
  //       else{
  //         alert(result.message)
  //       }
  //     });
  //   }
  // }

  // userLogin() {
  //   this.loginUserService.loginUser(this.user).subscribe(
  //     data => {
  //       alert('Login success');
  //     },
  //     error => {
  //       alert('User was not found');
  //     }
  //   );
  // }

  // userLogin() {
  //   const hash = bcrypt.hashSync(this.user.password, 10);
  //   this.user.password = hash;
  //   this.loginUserService.loginUser(this.user).subscribe(
  //     data => {
  //       alert('Login success');
  //     },
  //     error => {
  //       alert('User was not found');
  //     }
  //   );
  // }

  // userLogin()
  // {
  //   console.log(this.user)
  //   this.loginUserService.loginUser(this.user).subscribe(data=>{
  //     alert("Login success")
  //   }, error=>alert("User was not found"));
  // }

}
