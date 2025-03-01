package com.bcnc.product.architecture;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.domain.JavaClasses;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class HexagonalArchitectureTest {

    private final JavaClasses classes = new ClassFileImporter()
            .importPackages("com.bcnc.product");

    @Test
    void domainLayerShouldNotDependOnApplicationAndInfrastructureLayers() {
        noClasses()
            .that()
            .resideInAPackage("..domain..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..application..", "..infrastructure..")
            .check(classes);
    }

    @Test
    void applicationLayerShouldNotDependOnInfrastructureLayer() {
        noClasses()
            .that()
            .resideInAPackage("..application..")
            .should()
            .dependOnClassesThat()
            .resideInAPackage("..infrastructure..")
            .check(classes);
    }

    @Test
    void layeredArchitectureShouldBeRespected() {
        layeredArchitecture()
            .consideringAllDependencies()
            .layer("Domain").definedBy("..domain..")
            .layer("Application").definedBy("..application..")
            .layer("Infrastructure").definedBy("..infrastructure..")
            .whereLayer("Domain").mayOnlyBeAccessedByLayers("Application", "Infrastructure")
            .whereLayer("Application").mayOnlyBeAccessedByLayers("Infrastructure")
            .check(classes);
    }

    @Test
    void portsShouldBeInterfaces() {
        classes()
            .that()
            .resideInAPackage("..port..")
            .should()
            .beInterfaces()
            .check(classes);
    }

}