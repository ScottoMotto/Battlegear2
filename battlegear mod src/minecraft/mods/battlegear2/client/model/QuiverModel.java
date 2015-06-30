package mods.battlegear2.client.model;


import mods.battlegear2.client.utils.BattlegearRenderHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

import java.util.Random;

public class QuiverModel extends ModelBase
{
    private final ModelRenderer body;
    private final ModelRenderer quiverBase;
    private final ModelRenderer quiverRight;
    private final ModelRenderer quiverBottom;
    private final ModelRenderer quiverLeft;
    private final ModelRenderer quiverTop;

    private final float[][] arrowPos = new float[10][3];

    public QuiverModel()
    {
        super();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            arrowPos[i] = new float[]{r.nextFloat()*2F/16F, r.nextFloat()*4F, r.nextFloat() * 3F/16F};
        }

        body = new ModelRenderer(this, 16, 16).addBox(-4F, 0.0F, -2F, 8, 12, 4);
        quiverBase = new ModelRenderer(this, 0, 0).addBox(-6F, 1.0F, 2.0F, 8, 4, 3);
        quiverBase.rotateAngleZ = -0.7853982F;
        quiverRight = new ModelRenderer(this, 0, 16).addBox(-0.6F, 0.1F, 0.0F, 1, 2, 3);
        quiverRight.setRotationPoint(-3F, 5F, 2.0F);
        quiverRight.rotateAngleZ = 0.2617994F;
        quiverBottom = new ModelRenderer(this, 0, 11).addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
        quiverBottom.setRotationPoint(-2.7F, 5.5F, 2.0F);
        quiverBottom.rotateAngleZ = 0.7853982F;
        quiverLeft = new ModelRenderer(this, 0, 21).addBox(0.0F, 0.0F, 0.0F, 1, 2, 3);
        quiverLeft.setRotationPoint(-2.7F, 8.3F, 2.0F);
        quiverLeft.rotateAngleZ = -1.832596F;
        quiverTop = new ModelRenderer(this, 0, 7).addBox(1.0F, -3F, 0.0F, 4, 1, 3);
        quiverTop.setRotationPoint(0.0F, 0.0F, 2.0F);
        quiverTop.rotateAngleZ = 0.7853982F;
    }

    //@Override
    public void render(int arrowCount, float par7) {
        //super.render(par1Entity, par2, par3, par4, par5, par6, par7);

        body.render(par7);
        quiverBase.render(par7);
        quiverRight.render(par7);
        quiverBottom.render(par7);
        quiverLeft.render(par7);
        quiverTop.render(par7);

        for(int i = 0; i < arrowCount && i < arrowPos.length; i++){
            GL11.glPushMatrix();
            quiverBase.postRender(par7);
            GL11.glTranslatef(-14F/16F + arrowPos[i][2], -3F/16F, 2.5F/16F+arrowPos[i][0]);
            BattlegearRenderHelper.renderArrow(true, 0, -arrowPos[i][1], 1, 0, 0);
            GL11.glPopMatrix();
        }

    }
}