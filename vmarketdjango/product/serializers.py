from rest_framework import serializers
from product.models import Category, Product

class ProductSerializers(serializers.ModelSerializer):
    class Meta:
        model = Product
        fields = (
            "id",
            "name", 
            "get_absolute_url",
            "description",
            "price",
            "get_image",
            "get_thumbnail",
        )