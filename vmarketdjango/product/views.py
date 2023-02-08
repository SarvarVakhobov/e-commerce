from django.shortcuts import render
from django.http import Http404

from rest_framework.views import APIView
from rest_framework.response import Response

from product.models import Product
from product.serializers import ProductSerializers

class LatestProductsList(APIView):
    def get(self, request, format=None):
        product = Product.objects.all()[0:4]
        seralizer = ProductSerializers(product, many=True)
        return Response(seralizer.data)


class ProductDetail(APIView):
    def get_object(self, category_slug, product_slug):
        try:
            return Product.objects.filter(category__slug=category_slug).get(slug=product_slug)
        except Product.DoesNotExist:
            raise Http404

    def get(self, request, category_slug, product_slug, format=None):
        product = self.get_object(category_slug, product_slug)
        serializer = ProductSerializers(product)
        return Response(serializer.data)