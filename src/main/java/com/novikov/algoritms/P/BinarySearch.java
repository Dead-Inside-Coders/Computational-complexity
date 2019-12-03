package com.novikov.algoritms.P;

public class BinarySearch
{

    //По дэфолту left = 0 , right = array.lenght
    public Integer binarySearchRec(Integer[]array , int key , int left , int right)
    {
        int mid = (left+right)/2;
        if(key == array[mid])
        {
            return mid;
        }
        if (key < array[mid])
        {
            return binarySearchRec(array,key,left,mid);
        }
        else
        {
            return binarySearchRec(array,key,mid,right);
        }

    }
    public Integer binarySearchIterational(Integer[]array , int key)
    {
        int left = 0,right = array.length;

        while (left <= right) // пока левая граница не "перескочит" правую
        {

            int mid = (left + right) / 2; // ищем середину отрезка
            if (key == array[mid]) {  // если ключевое поле равно искомому
                return mid;     // мы нашли требуемый элемент,

            }
            if (key < array[mid])     // если искомое ключевое поле меньше найденной середины
                right = mid - 1;  // смещаем правую границу, продолжим поиск в левой части
            else                  // иначе
                left = mid + 1;   // смещаем левую границу, продолжим поиск в правой части
        }
        return -(1 + left);
    }




}
