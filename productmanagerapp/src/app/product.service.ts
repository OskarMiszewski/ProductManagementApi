import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable } from 'rxjs';
import { Product } from './product';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  //private apiServerUrl = environment.apiBaseUrl;


  constructor(private http: HttpClient) { }

  public getAllProducts(): Observable<Product[]>
  {
    return this.http.get<Product[]>('http://localhost:8080/product/find/all');
  }

  public addProduct(product: Product): Observable<Product>
  {
    return this.http.post<Product>('http://localhost:8080/product/add',product);
  }

  public updateProduct(product: Product): Observable<Product>
  {
    return this.http.put<Product>('http://localhost:8080/product/update',product);
  }

  // public deleteProduct(productId: number): Observable<Product>{
  //   return this.http.delete<Product>('http://localhost:8080/product/delete/${productId}')
  // }

  public deleteProduct(productId: number): Observable<void>{
    return this.http.delete<void>('http://localhost:8080/product/delete/' + productId)
  }

  // public getById(productId: Product): Observable<Product[]>
  // {
  //   return this.http.get<Product[]>('http:localhost:8080/find/productId')
  // }
}
